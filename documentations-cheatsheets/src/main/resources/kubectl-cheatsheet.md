  
#### 1. Create namespace  
> kubectl create namespace health-check  
  
##### 2. Create secret for AWS ECR Login   
> kubectl create secret docker-registry aws-ecr --docker-server=${AWS_ACCOUNT}.dkr.ecr.${AWS_REGION}.amazonaws.com \  
  --docker-username=AWS --docker-password=$(aws ecr get-login-password) \  
  --namespace=health-check  
    
##### 3. Deploy k8s file  
> kubectl apply -f manifest.yml  
  
#### Important commands  
##### Deploy from file or image  
> kubectl apply -f ./my-manifest.yaml            # create resource(s)    
> kubectl apply -f ./my1.yaml -f ./my2.yaml      # create from multiple files  
> kubectl apply -f ./dir                         # create resource(s) in all manifest files in dir  
> kubectl apply -f https://git.io/vPieo          # create resource(s) from url  
> kubectl create deployment nginx --image=nginx  # start a single instance of nginx  
  
##### Run cron job every minute  
> kubectl create cronjob hello --image=busybox   --schedule="*/1 * * * *" -- echo "Hello World"    
  
##### Update Resources  
> kubectl set image deployment/frontend www=image:v2               # Rolling update "www" containers of "frontend" deployment, updating the image  
> kubectl rollout history deployment/frontend                      # Check the history of deployments including the revision   
> kubectl rollout undo deployment/frontend                         # Rollback to the previous deployment  
> kubectl rollout undo deployment/frontend --to-revision=2         # Rollback to a specific revision  
> kubectl rollout status -w deployment/frontend                    # Watch rolling update status of "frontend" deployment until completion  
> kubectl rollout restart deployment/frontend                      # Rolling restart of the "frontend" deployment  
  
##### Edit Resources  
> kubectl edit svc/docker-registry                      # Edit the service named docker-registry  
> KUBE_EDITOR="nano" kubectl edit svc/docker-registry   # Use an alternative editor  
  
##### Scaling the Resources  
> kubectl scale --replicas=3 rs/foo                                 # Scale a replicaset named 'foo' to 3  
> kubectl scale --replicas=3 -f foo.yaml                            # Scale a resource specified in "foo.yaml" to 3  
> kubectl scale --current-replicas=2 --replicas=3 deployment/mysql  # If the deployment named mysql's current size is 2, scale mysql to 3  
> kubectl scale --replicas=5 rc/foo rc/bar rc/baz                   # Scale multiple replication controllers  
  
##### nteracting with running Pods  
> kubectl logs my-pod                                 # dump pod logs (stdout)  
> kubectl logs -l name=myLabel                        # dump pod logs, with label name=myLabel (stdout)  
> kubectl logs my-pod --previous                      # dump pod logs (stdout) for a previous instantiation of a container  
> kubectl logs my-pod -c my-container                 # dump pod container logs (stdout, multi-container case)  
> kubectl logs -l name=myLabel -c my-container        # dump pod logs, with label name=myLabel (stdout)  
> kubectl logs my-pod -c my-container --previous      # dump pod container logs (stdout, multi-container case) for a previous instantiation of a > container  
> kubectl logs -f my-pod                              # stream pod logs (stdout)  
> kubectl logs -f my-pod -c my-container              # stream pod container logs (stdout, multi-container case)  
> kubectl logs -f -l name=myLabel --all-containers    # stream all pods logs with label name=myLabel (stdout)  
> kubectl run -i --tty busybox --image=busybox -- sh  # Run pod as interactive shell  
> kubectl run nginx --image=nginx -n mynamespace      # Start a single instance of nginx pod in the namespace of mynamespace  
> kubectl run nginx --image=nginx                     # Run pod nginx and write its spec into a file called pod.yaml  
--dry-run=client -o yaml > pod.yaml  
  
> kubectl attach my-pod -i                            # Attach to Running Container  
> kubectl port-forward my-pod 5000:6000               # Listen on port 5000 on the local machine and forward to port 6000 on my-pod  
> kubectl exec my-pod -- ls /                         # Run command in existing pod (1 container case)  
> kubectl exec --stdin --tty my-pod -- /bin/sh        # Interactive shell access to a running pod (1 container case)   
> kubectl exec my-pod -c my-container -- ls /         # Run command in existing pod (multi-container case)  
> kubectl top pod POD_NAME --containers               # Show metrics for a given pod and its containers  
> kubectl top pod POD_NAME --sort-by=cpu     
  
##### Copy files and directories to and from containers  
> kubectl cp /tmp/foo_dir my-pod:/tmp/bar_dir            # Copy /tmp/foo_dir local directory to /tmp/bar_dir in a remote pod in the current namespace  
> kubectl cp /tmp/foo my-pod:/tmp/bar -c my-container    # Copy /tmp/foo local file to /tmp/bar in a remote pod in a specific container  
> kubectl cp /tmp/foo my-namespace/my-pod:/tmp/bar       # Copy /tmp/foo local file to /tmp/bar in a remote pod in namespace my-namespace  
> kubectl cp my-namespace/my-pod:/tmp/foo /tmp/bar       # Copy /tmp/foo from a remote pod to /tmp/bar locally  
  
##### Interacting with Deployments and Services  
> kubectl logs deploy/my-deployment                         # dump Pod logs for a Deployment (single-container case)  
> kubectl logs deploy/my-deployment -c my-container         # dump Pod logs for a Deployment (multi-container case)  
  
> kubectl port-forward svc/my-service 5000                  # listen on local port 5000 and forward to port 5000 on Service backend  
> kubectl port-forward svc/my-service 5000:my-service-port  # listen on local port 5000 and forward to Service target port with name <my-service-port>  
  
> kubectl port-forward deploy/my-deployment 5000:6000       # listen on local port 5000 and forward to port 6000 on a Pod created by <my-deployment>  
> kubectl exec deploy/my-deployment -- ls                   # run command in first Pod and first container in Deployment (single- or multi-container cases)  
  
##### Interacting with Nodes and cluster  
> kubectl cordon my-node                                                # Mark my-node as unschedulable  
> kubectl drain my-node                                                 # Drain my-node in preparation for maintenance  
> kubectl uncordon my-node                                              # Mark my-node as schedulable  
> kubectl top node my-node                                              # Show metrics for a given node  
> kubectl cluster-info                                                  # Display addresses of the master and services  
> kubectl cluster-info dump                                             # Dump current cluster state to stdout  
> kubectl cluster-info dump --output-directory=/path/to/cluster-state   # Dump current cluster state to /path/to/cluster-state  
  
  
> source <(kubectl completion bash) # setup autocomplete in bash into the current shell, bash-completion package should be installed first.  
> echo "source <(kubectl completion bash)" >> ~/.bashrc # add autocomplete permanently to your bash shell.  