__Install Vault__

* curl -fsSL https://apt.releases.hashicorp.com/gpg | sudo apt-key add -
* sudo apt-add-repository "deb [arch=amd64] https://apt.releases.hashicorp.com $(lsb_release -cs) main"
* sudo apt-get update && sudo apt-get install vault
* vault
* vault --version
* __ Start Vault server__
    * vault server -dev
* export VAULT_ADDR='http://127.0.0.1:8200'
* export VAULT_TOKEN="hvs.JaR1pjIXXHUupxnBQuglQY79"
* __ Browser__
  * http://localhost:8200/ui/vault/auth?with=token
* __Key/Value secrets engine__
  * vault kv put secret/foo bar=baz
  * vault kv get secret/foo
  * vault kv metadata get secret/foo
  * vault kv get -format=json secret/foo
  * vault kv delete secret/hello
  * vault secrets list
  * vault secrets enable -path=kv kv
  * vault secrets enable kv
  * vault token create
  * vault login
  * vault auth list
  * vault auth help github

* AWS Configure
  * vault secrets enable -path=aws aws
  * vault secrets list
  * vault write aws/config/root access_key=$AWS_ACCESS_KEY_ID secret_key=$AWS_SECRET_ACCESS_KEY region=ap-south-1
  * vault read aws/config/root

* __WEB API's__
  * curl http://127.0.0.1:8200/v1/sys/init
  * curl \
    --request POST \
    --data '{"secret_shares": 1, "secret_threshold": 1}' \
    http://127.0.0.1:8200/v1/sys/init | jq
  * curl \
    --header "X-Vault-Token: $VAULT_TOKEN" \
    --request POST \
    --data '{ "data": {"password": "my-long-password"} }' \
    http://127.0.0.1:8200/v1/secret/data/creds | jq -r ".data"
  * 



__Instal Vault from Docker Image__

__Install Vautl Through Helm Chart__
* helm repo add hashicorp https://helm.releases.hashicorp.com
* helm repo update
* kubectl create ns vault
* helm install vault hashicorp/vault --set "server dev.enabled=true" -n vault
* kubectl get pod -n vault
* kubectl exec -it vault-0 -n vault -- /bin/sh
* kubectl port-forward service/vault 8200:8200 -n vault
* http://localhost:8200
* in order to log in there use the Token method (a default token value is root)
* __Enable Vault Database Engine__
  * vault secrets enable database
  * vault write database/config/postgres \
    plugin_name=postgresql-database-plugin \
    allowed_roles="default" \
    connection_url="postgresql://{{username}}:{{password}}@postgres.default:5432?sslmode=disable" \
    username="postgres" \
    password="admin123"



__Install Vault from Kubernates__