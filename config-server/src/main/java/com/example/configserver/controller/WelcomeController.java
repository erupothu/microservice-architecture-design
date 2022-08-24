package com.example.configserver.controller;

import java.net.URI;
import java.net.URISyntaxException;

import com.example.configserver.data.DatabaseCredentials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultKeyValueOperations;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Value("${application.name.vault}")
    String vaultApplicationName;

    @Value("${vault.server.message}")
    String vaultMessage;

    @Autowired
    VaultTemplate vaultTemplate;
    
    @GetMapping("welcome-confg")
    public ResponseEntity<String> getWelcomeMessage() {

        return ResponseEntity.ok("welcome to Config Server");
    }


    @GetMapping("application-name-vault")
    public ResponseEntity<String> getApplicationNameFromVault() {

        return ResponseEntity.ok("Vault message: " + vaultApplicationName + " and \n" + vaultMessage);
    }

    @GetMapping("vault-add-db-credentials")
    public ResponseEntity<String> addDbCredentials() throws URISyntaxException {

        VaultEndpoint endpoint = VaultEndpoint.from(new URI("http://localhost:8200"));
VaultTemplate template = new VaultTemplate(endpoint, new TokenAuthentication("hvs.JaR1pjIXXHUupxnBQuglQY79"));

        DatabaseCredentials dbCred = new DatabaseCredentials();
        dbCred.setUsername("harish");
        dbCred.setPassword("hpass");

        template.write("secret/config-server-db", dbCred);

        return ResponseEntity.ok("Vault DB Credentials Write Successful");
    }

    @GetMapping("vault-read-db-credentials")
    public ResponseEntity<String> readDbCredentials() throws URISyntaxException {

        VaultEndpoint endpoint = VaultEndpoint.from(new URI("http://localhost:8200"));
        VaultTemplate template = new VaultTemplate(endpoint, new TokenAuthentication("hvs.JaR1pjIXXHUupxnBQuglQY79"));

        VaultResponseSupport response = template.read("secret/config-server");

        System.out.println(response);

        return ResponseEntity.ok("Vautl Read Successful DB Username: ");
    }
}
