

__Install Consul Server__

* curl -fsSL https://apt.releases.hashicorp.com/gpg | sudo apt-key add -
* sudo apt-add-repository "deb [arch=amd64] https://apt.releases.hashicorp.com $(lsb_release -cs) main"
* sudo apt-get update && sudo apt-get install consul
* sudo apt-get update && sudo apt-get install consul-enterprise.x86_64
* consul
* consul agent -dev # Start the agent
* consul members
* http://localhost:8500/ui/dc1/services
* curl localhost:8500/v1/catalog/nodes
* curl 'http://localhost:8500/v1/health/service/web?passing'
* consul reload
* consul leave

__Consul server as Vault__

* consul kv put redis/config/minconns 1
* consul kv put redis/config/maxconns 25
* consul kv put -flags=42 redis/config/users/admin abcd1234
* consul kv get redis/config/minconns
* consul kv get -detailed redis/config/users/admin
* consul kv get -recurse
* consul kv delete redis/config/minconns
* consul kv delete -recurse redis
* consul kv put foo bar
* consul kv get foo
* 