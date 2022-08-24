##### Install consul

curl -fsSL https://apt.releases.hashicorp.com/gpg | sudo apt-key add -
sudo apt-add-repository "deb [arch=amd64] https://apt.releases.hashicorp.com $(lsb_release -cs) main"
sudo apt-get update && sudo apt-get install consul

__Start an agent__

consul agent -dev

__Discover Agent__

consul members
curl localhost:8500/v1/catalog/nodes

__Check in browser__

localhost:8500

consul agent -server -bind=<ip> -client=<ip> -ui -data-dir=/data/consul -config-dir=/etc/consul -node=$(hostname) -datacenter=$datacenter &  

__stop Agent__

consul leave

##### Register Services

mkdir ./consul.d

cat web.json

```json
{
  "service": {
    "name": "web",
    "tags": [
      "rails"
    ],
    "port": 80
  }
}
```

consul agent -dev -enable-script-checks -config-dir=./consul.d

__Join a cluster__

consul join <ip> <ip> [<ip> [...]]  

__Show cluster info__

```
consul info        # show active config summary
consul members     # show cluster members
consul monitor     # tail activity log
consul reload      # reload config

consul keyring -list
consul keyring -install
consul keyring -use         # Use a key which was previously installed
consul keyring -remove 
```

__Add Values to consul__

consul kv put redis/config/minconns 1
consul kv put redis/config/maxconns 25
consul kv put -flags=42 redis/config/users/admin abcd1234

__Accessing the key-value store__

consul kv get -detailed redis/config/users/admin
consul kv get <path>
consul kv get --detailed <path>    # include metadata
consul kv put <path> <value>
consul kv delete <path>

__Dumping and importing values from/to JSON__

consul kv export [<prefix>] >values.json
consul kv import <values.json

__REST API__

/v1/catalog/nodes
/v1/catalog/services
 
/v1/agent/checks
/v1/agent/services
/v1/agent/service/register
 
/v1/health/checks/<service>