__Listing Containers__  

docker ps                           # List running containers  
docker ps -a                        # List all containers  
docker ps -s                        # List running containers including CPU/memory size  

__List machine readable:__

docker ps -a --format "{{.ID}},{{.Names}},{{.Status}},{{.Image}},{{.Ports}}"

__Inspecting containers__
docker exec -it <container> bash    # Log into container bash environment  
docker inspect <container>          # Instance details  
docker top     <container>          # Instance processes  
docker logs    <container>          # Instance console log  
docker port    <container>          # Shows container's port mapping. The same can be seen with "docker ps" though (row - "PORTS")  
docker diff    <container>          # Shows changes on container's filesystem. Will produce a list of files and folders prefixed by a  
                                    # character. "A" is for "added", "C" is for changed.  
docker stats   <container>          # Shows the consumed resources (memory, CPU, network bandwidth)  
docker export --output="latest.tar" <container> #Export a container’s filesystem as a tar archive  

__Starting containers__  

docker start -it ubuntu

__docker run -i -t ubuntu /bin/bash   # New instance from image. "-i" is for "interactive" and "t" is for terminal. Without "it" it
                                    # won't be interactive - you will get a shell/terminal, but will not be able to type anything onto 
                                    # it. Without "t" you will not get a terminal opened. The command will run and exit.  
                                    
docker run -i -t --rm ubuntu /bin/bash # If you need a one-time container, then use the --rm option. Thus, once you exit the container,
                                    # it will be removed      
                                    
__Start with port forwarding__

docker run -p 8080:8080 myserver  
docker network create --subnet=172.18.0.0/16 elknet        # Create a network 'elknet'  
docker run --net elknet --ip 172.18.0.22 -it ubuntu bash   # Assign static IP from network  

__Container and image lifecycle__

ocker start   <container>  
docker restart <container>  
docker stop    <container>  
docker attach  <container>  
docker rm [-f] <container>          # Removes / deletes a container (do not confuse with the "rmi" command - it removes an image!).  
                                    # The container must be stopped in beforehand (unless -f is used).  

docker cp '<id>':/data/file .       # Copy file out of container  

docker images                       # List locally stored images  
docker rmi <image>                  # Removes / deletes a locally stored image  
docker save -o <tarball> <image>    # Saves a local image as a tarball, so you can archive/transfer or inspect its content  
                                    # Example: docker save -o /tmp/myimage.tar busybox  
docker history <image>              # Shows image creation history. Useful if you want to "recreate" the Dockerfile of an image -  
                                    # in cases where you are interested how the image has been created.  
                                  
__Building Images__

docker build .  
docker build -f Dockerfile.test .                     # Use another Dockerfile file name  
docker build --target <stage> .                       # Build specific target of a multi-stage Dockerfile  
docker build --build-arg MYARG=myvalue .              # Pass variables with --build-arg  
docker build --add-host <hostname>:<target> .         # Inject hostnames  

__Releasing Images__

docker tag <source>[:<tag>] <target>:<tag>  
docker push <target>:<tag>  

__To a private/remote registry__

docker tag <source>[:<tag>] <remote registry>/<target>:<tag>  
docker push <remote registry>/<target>:<tag>  

__Networks__

docker network ls
docker network rm <network id>
docker network inspect <network id>

__Docker Registry v2 API__

/v2/_catalog                # List repositories  
/v2/<repository>/tags/list  # List tags for a given repo  

__DockerHub Rate Limits + Solutions__

https://inlets.dev/blog/2020/10/29/preparing-docker-hub-rate-limits.html

__Copying files out__

docker create --name <container name> <image tag>  
docker cp <container name>:<source path> <target path>  
docker rm -f <container name>  
