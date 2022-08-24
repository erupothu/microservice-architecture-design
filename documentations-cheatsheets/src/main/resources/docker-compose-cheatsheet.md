__CLI__  

docker-compose up           # start docker-compose.yml from current dir  
docker-compose down  
 
 __Network__  
 
 
 ``` networks:
  app_net:                                   # <-- any name goes here
    driver: bridge
    enable_ipv6: true
    ipam:
      driver: default
      config:
        - subnet: 172.16.238.0/24
          gateway: 172.16.238.1
        - subnet: 2001:3984:3989::/64        
          gateway: 2001:3984:3989::1```
          

__Service__   


``` services:
  my_app:
    image: busybox
    command: ifconfig
    networks:
      app_net:
        ipv4_address: 172.16.238.10
        ipv6_address: 2001:3984:3989::10```
        

__DOCKER_HOST__  

export DOCKER_HOST=127.0.0.1:2375  
