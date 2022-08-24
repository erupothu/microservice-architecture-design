
> aws ecr get-login-password --region ap-south-1 | docker login --username AWS --password-stdin 470702883802.dkr.ecr.ap-south-1.amazonaws.com  

> docker build -t <image-name> .  
> docker tag java-interview:latest 470702883802.dkr.ecr.ap-south-1.amazonaws.com/<image-name>:latest  
> docker push 470702883802.dkr.ecr.ap-south-1.amazonaws.com/<image-name>:latest  

> docker pull 470702883802.dkr.ecr.ap-south-1.amazonaws.com/<image-name>:latest  