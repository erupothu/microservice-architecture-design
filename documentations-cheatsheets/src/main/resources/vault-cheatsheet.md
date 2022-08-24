
__Install Vault__

curl -fsSL https://apt.releases.hashicorp.com/gpg | sudo apt-key add -
sudo apt-add-repository "deb [arch=amd64] https://apt.releases.hashicorp.com $(lsb_release -cs) main"
sudo apt-get update && sudo apt-get install vault

__Checking__

$ vault
$ vault --version

__ Start Vault server__
$ vault server -dev
export VAULT_ADDR='http://127.0.0.1:8200'
export VAULT_TOKEN="hvs.JaR1pjIXXHUupxnBQuglQY79"

__ Browser__
http://localhost:8200/ui/vault/auth?with=token


__Check status__
$ vault status

__Key/Value secrets engine__

vault kv put secret/foo bar=baz

vault kv get secret/foo
vault kv metadata get secret/foo
vault kv get -version=1 secret/foo
vault kv get -format=json secret/foo
vault kv delete secret/hello

__Enable a secrets engine__

vault secrets enable -path=kv kv
vault secrets enable kv
vault secrets list

vault kv put kv/hello target=world
vault kv get kv/hello

__Disable a secrets engine__

vault secrets disable kv/


__ Enable the AWS secrets engine __

vault secrets enable -path=aws aws
export AWS_ACCESS_KEY_ID=<aws_access_key_id>
export AWS_SECRET_ACCESS_KEY=<aws_secret_key>

vault write aws/config/root \
    access_key=$AWS_ACCESS_KEY_ID \
    secret_key=$AWS_SECRET_ACCESS_KEY \
    region=ap-south-1
    
vault read aws/creds/my-role
vault lease revoke aws/creds/my-role/0bce0782-32aa-25ec-f61d-c026ff22106

__Authentication__

vault token create
vault login
vault token revoke s.iyNUhq8Ov4hIAx6snw5mB2nL

__GitHub authentication__

vault auth enable github
vault write auth/github/config organization=hashicorp
vault write auth/github/map/teams/engineering value=default,applications
vault auth list
vault login -method=github

__Policy Format__

cat policy.hcl

```
path "secret/data/*" {
  capabilities = ["create", "update"]
}

path "secret/data/foo" {
  capabilities = ["read"]
}
```

vault policy read default
vault policy write -h

```
vault policy write my-policy - << EOF
# Dev servers have version 2 of KV secrets engine mounted by default, so will
# need these paths to grant permissions:
path "secret/data/*" {
  capabilities = ["create", "update"]
}

path "secret/data/foo" {
  capabilities = ["read"]
}
EOF
```
vault policy list
vault policy read my-policy
export VAULT_TOKEN="$(vault token create -field token -policy=my-policy)"
vault token lookup | grep policies
vault kv put secret/creds password="my-long-password"

__Associate Policies to Auth Methods__

export VAULT_TOKEN=root
vault auth enable approle
vault write auth/approle/role/my-role \
    secret_id_ttl=10m \
    token_num_uses=10 \
    token_ttl=20m \
    token_max_ttl=30m \
    secret_id_num_uses=40 \
    token_policies=my-policy
    
export ROLE_ID="$(vault read -field=role_id auth/approle/role/my-role/role-id)"
export SECRET_ID="$(vault write -f -field=secret_id auth/approle/role/my-role/secret-id)"
vault write auth/approle/login role_id="$ROLE_ID" secret_id="$SECRET_ID"

__Configuring Vault__

cat config.hcl

```
storage "raft" {
  path    = "./vault/data"
  node_id = "node1"
}

listener "tcp" {
  address     = "127.0.0.1:8200"
  tls_disable = "true"
}

api_addr = "http://127.0.0.1:8200"
cluster_addr = "https://127.0.0.1:8201"
ui = true

```
mkdir -p ./vault/data
vault server -config=config.hcl

__HTTP Apis__
$ curl \
    --header "X-Vault-Token: $VAULT_TOKEN" \
    --request POST \
    --data '{ "data": {"password": "my-long-password"} }' \
    http://127.0.0.1:8200/v1/secret/data/creds | jq -r ".data"
    
$ curl \
    --header "X-Vault-Token: $VAULT_TOKEN" \
     http://127.0.0.1:8200/v1/auth/approle/role/my-role/role-id | jq -r ".data"
    
