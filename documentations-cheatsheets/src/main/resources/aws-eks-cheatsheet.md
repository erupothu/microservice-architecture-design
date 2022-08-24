
> aws --version
> aws sts get-caller-identity
> eksctl create cluster --version=1.14 --name suhas-eks-test --region us-east-1 --zones us-east-1a,us-east-1b --node-type t2.medium --nodes 2 --vpc-public-subnets=subnet-123,subnet-456  --ssh-access=true --ssh-public-key vayafinserv-live
> eksctl create cluster --name vaya-eks-cluster --region ap-south-1 --zones ap-south-1a,ap-south-1b --managed --nodegroup-name vayanodegroup (OR)
> eksctl create cluster --name my-cluster --version 1.21 --without-nodegroup (OR)
> aws eks --region <region> create-cluster --name <clusterName> --role-arn <EKS-role-ARN> --resources-vpc-config \
	subnetIds=<subnet-id-1>,<subnet-id-2>,<subnet-id-3>,securityGroupIds=<security-group-id> (OR)
> eksctl create cluster -f cluster.yaml

> aws eks --region ap-south-1 describe-cluster --name vaya-eks-cluster --query cluster.status

> eksctl delete cluster vaya-eks-cluster

> eksctl get cluster
> eksctl get nodegroup --cluster CLUSTERNAME
> eksctl scale nodegroup --cluster CLUSTERNAME --name NODEGROUPNAME --nodes NEWSIZE

> eksctl scale nodegroup --cluster CLUSTERNAME --name NODEGROUPNAME --nodes 0 --nodes-max 1 --nodes-min 0

#### Cloud watch logs
> eksctl utils update-cluster-logging --config-file=<path>
> eksctl utils update-cluster-logging --enable-types all (OR)
> eksctl utils update-cluster-logging --enable-types audit
> eksctl utils update-cluster-logging --enable-types=all --disable-types=controllerManager
> eksctl utils update-cluster-logging --enable-types=controllerManager --disable-types=scheduler

#### Login
> aws eks --region ap-south-1 update-kubeconfig --name <cluster-name>


#### Next Step check kubectl commands for Deployment into Cluster
> kubectl get svc
> kubectl apply -f /k8s-helloworld/helloworld.yaml
> kubectl apply -f /k8s-helloworld/helloworld-service.yaml
> kubectl get svc service-helloworld -o yaml
> kubectl logs deployment.apps/vaya-reports-deployment

#### Upgrade
> eksctl upgrade cluster --name=myekscluster --approve
> eksctl upgrade nodegroup --cluster=myekscluster --name=mynodegroup
