#### Security with spring security 

##### Industry standard Public Key Cryptographic Standard (PKCS12)
> keytool -genkey -alias sslsecurity -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12 -validity 3650

##### Java KeyStore
> keytool -genkeypair -alias sslsecurity -keyalg RSA -keysize 2048 -keystore keystore.jks -validity 3650

##### Convert JKS to PKCS12
> keytool -importkeystore -srckeystore baeldung.jks -destkeystore baeldung.p12 -deststoretype pkcs12