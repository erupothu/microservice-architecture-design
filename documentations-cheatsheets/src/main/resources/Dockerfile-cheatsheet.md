

__Dockerfile Examples__  

```
FROM debian:jessie

ENV DEBIAN_FRONTEND=noninteractive             # Always have this on Debian-based distros!

# Always
# - combine update + install to avoid apt caching issues!
# - disable recommends to get no extra packages!
# - clean lists afterwards
RUN apt-get update \
 && apt-get install -y --no-install-recommends python git
 && apt-get clean \
 && rm -rf /var/lib/apt/lists/*
 ```
 
 __Copy files__
 
 ```
 COPY sourcefile.txt /app
COPY sourcefile.txt config.ini /app/           # Note the trailing slash on target with multiple files 
COPY dir1 /app
```

__Adding users__

RUN useradd jsmith -u 1001 -s /bin/bash

__Defining work directories and environment__  

WORKDIR /home/jsmith/
ENV HOME /home/jsmith

VOLUME ["/home"]  

__Start command with parameters__

ENTRYPOINT [ "script.sh", "param1", "param2"]            # using ENTRYPOINT command cannot be overridden, only parameters can be appended  
CMD [ "script.sh", "param1", "param2"]                   # using CMD "docker run" can override command and parameters  

__Setting timezone__

ENV TZ=America/Los_Angeles  
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone  

__Clear apt cache__

```
RUN apt-get update \
  && apt-get install --no-install-recommends -y <packages> \
  && apt-get clean \
  && rm -rf /var/lib/apt/lists/*
  ```
  
  
