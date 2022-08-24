

> aws --version
> aws sts get-caller-identity
> eksctl create cluster --name vaya-eks-cluster --region ap-south-1 --zones ap-south-1a,ap-south-1b --managed --nodegroup-name vayanodegroup
> aws eks --region ap-south-1 update-kubeconfig --name vaya-eks-cluster
> eksctl create cluster --name my-cluster --version 1.21 --without-nodegroup
> aws eks --region ap-south-1 describe-cluster --name vaya-eks-cluster --query cluster.status

##### Deploy Application with kubectl
> kubectl get svc
> kubectl apply -f /k8s-helloworld/helloworld.yaml
> kubectl apply -f /k8s-helloworld/helloworld-service.yaml
> kubectl get svc service-helloworld -o yaml