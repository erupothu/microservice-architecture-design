
##### Install Redis and RabbitMQ

wget -O- https://packages.erlang-solutions.com/ubuntu/erlang_solutions.asc | apt-key add -
echo "deb http://binaries.erlang-solutions.com/debian $(lsb_release -cs) contrib" | tee /etc/apt/sources.list.d/erlang-solutions.list
apt-get update -y
apt-get install rabbitmq-server -y
rabbitmqctl add_vhost /sensu
rabbitmqctl add_user sensu password
rabbitmqctl set_permissions -p /sensu sensu ".*" ".*" ".*"


apt-get install redis-server -y
systemctl start redis-server
systemctl enable redis-server

wget -O- https://sensu.global.ssl.fastly.net/apt/pubkey.gpg | apt-key add -
echo "deb https://sensu.global.ssl.fastly.net/apt bionic main" | tee /etc/apt/sources.list.d/sensu.list
apt-get update -y
apt-get install sensu -y
nano /etc/sensu/conf.d/api.json

```
{
  "api": {
    "host": "localhost",
    "bind": "0.0.0.0",
    "port": 4567
  }
}
```

nano /etc/sensu/conf.d/redis.json

```
{
  "redis": {
    "host": "127.0.0.1",
    "port": 6379
  }
}
```

nano /etc/sensu/conf.d/rabbitmq.json

```
{
  "rabbitmq": {
    "host": "127.0.0.1",
    "port": 5672,
    "vhost": "/sensu",
    "user": "sensu",
    "password": "password"
  }
}
```


apt-get install uchiwa -y
nano /etc/sensu/uchiwa.json

```
{
  "sensu": [
    {
      "name": "Sensu",
      "host": "127.0.0.1",
      "port": 4567,
      "timeout": 10
    }
  ],
  "uchiwa": {
    "host": "0.0.0.0",
    "port": 3000,
    "refresh": 10
  }
}
```

nano /etc/sensu/conf.d/client.json

```
{
  "client": {
    "name": "sensu-server",
    "address": "127.0.0.1",
    "environment": "management",
    "subscriptions": [
      "dev",
      "ubuntu"
   ],
    "socket": {
      "bind": "127.0.0.1",
      "port": 3030
    }
  }
}
```

systemctl start sensu-server
systemctl start sensu-api
systemctl start uchiwa
systemctl start sensu-client

http://your-server-ip:3000.


__Another way__

__Install Sensu Go Backend __

curl -s https://packagecloud.io/install/repositories/sensu/stable/script.deb.sh | bash
apt-get install sensu-go-backend -y
curl -L https://docs.sensu.io./sensu-go/latest/files/backend.yml -o backend.yml
mv backend.yml /etc/sensu/backend.yml
systemctl start sensu-backend
systemctl enable sensu-backend

sensu-backend init --interactive

http://your-server-ip:3000

__Install Sensuctl__

curl -s https://packagecloud.io/install/repositories/sensu/stable/script.deb.sh | bash
apt-get install sensu-go-cli -y
sensuctl configure

__Install Sensu Go Agent__

apt-get install sensu-go-agent -y
curl -L https://docs.sensu.io/sensu-go/latest/files/agent.yml -o agent.yml
mv agent.yml /etc/sensu/agent.yml
systemctl start sensu-agent