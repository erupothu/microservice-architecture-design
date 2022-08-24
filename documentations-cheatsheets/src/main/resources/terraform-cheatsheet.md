
  

##### Installation AWS  
> install awscli  
> nano ~/.aws/credentials  
> aws configure  
> git clone https://github.com/hashicorp/learn-terraform-provision-eks-cluster  
> cd learn-terraform-provision-eks-cluster  

##### Basic commands
> terraform get  
> terraform init  
> terraform plan  
> terraform apply  
> terraform destroy  
> terraform apply -refresh-only
> terraform apply -auto-approve
> terraform output
> terraform init -upgrade
> terraform console
   > var.private_subnet_cidr_blocks
   > var.private_subnet_cidr_blocks[1]
   > slice(var.private_subnet_cidr_blocks, 0, 3)

##### Configure kubectl  
> aws eks --region $(terraform output -raw region) update-kubeconfig --name $(terraform output -raw cluster_name)  
   
##### Deploy and access Kubernetes Dashboard  
> wget -O v0.3.6.tar.gz https://codeload.github.com/kubernetes-sigs/metrics-server/tar.gz/v0.3.6 && tar -xzf v0.3.6.tar.gz  
> kubectl apply -f metrics-server-0.3.6/deploy/1.8+/  
> kubectl get deployment metrics-server -n kube-system  
> kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.0.0-beta8/aio/deploy/recommended.yaml  
> kubectl proxy  
> kubectl apply -f https://raw.githubusercontent.com/hashicorp/learn-terraform-provision-eks-cluster/main/kubernetes-dashboard-admin.rbac.yaml  
> kubectl -n kube-system describe secret $(kubectl -n kube-system get secret | grep service-controller-token | awk '{print $1}')  
   
##### Terraform Important commands  
> terraform -install-autocomplete  

##### Format and Validate Terraform code  
> terraform fmt #format code per HCL canonical standard  
> terraform validate #validate code for syntax  
> terraform validate -backend=false #validate code skip  

##### Initialize your Terraform working directory  
> terraform init #initialize directory, pull down providers  
> terraform init -get-plugins=false #initialize directory, do not download plugins  
> terraform init -verify-plugins=false #initialize directory, do not verify plugins for Hashicorp signature  

##### Plan, Deploy and Cleanup Infrastructure  
> terraform apply --auto-approve #apply changes without being prompted to enter “yes”  
> terraform destroy --auto-approve #destroy/cleanup deployment without being prompted for “yes”  
> terraform plan -out plan.out #output the deployment plan to plan.out  
> terraform apply plan.out #use the plan.out plan file to deploy infrastructure  
> terraform plan -destroy #outputs a destroy plan  
> terraform apply -target=aws_instance.my_ec2 #only apply/deploy changes to the targeted resource  
> terraform apply -var my_region_variable=us-east-1 #pass a variable via command-line while applying a configuration  
> terraform apply -lock=true #lock the state file so it can’t be modified by any other Terraform apply or modification action(possible only where backend allows locking)  
> terraform apply refresh=false # do not reconcile state file with real-world resources(helpful with large complex deployments for saving deployment time)  
> terraform apply --parallelism=5 #number of simultaneous resource operations  
> terraform refresh #reconcile the state in Terraform state file with real-world resources  
> terraform providers #get information about providers used in current configuration  

##### Terraform Workspaces  
> terraform workspace new mynewworkspace #create a new workspace  
> terraform workspace select default #change to the selected workspace  
> terraform workspace list #list out all workspaces  
> terraform workspace delete mynewworkspace
> terraform workspace show  

##### Terraform State Manipulation  
> terraform state show aws_instance.my_ec2 #show details stored in Terraform state for the resource  
> terraform state pull terraform.tfstate #download and output terraform state to a file  
> terraform state mv aws_iam_role.my_ssm_role module.custom_module #move a resource tracked via state to different module  
> terraform state replace-provider hashicorp/aws registry.custom.com/aws #replace an existing provider with another  
> terraform state list #list out all the resources tracked via the current state file  
> terraform state rm  aws_instance.myinstace #unmanage a resource, delete it from Terraform state file  

##### Terraform Import And Outputs  
> terraform import aws_instance.new_ec2_instance i-abcd1234 #import EC2 instance with id i-abcd1234 into the Terraform resource named “new_ec2_instance” of type “aws_instance”  
> terraform import 'aws_instance.new_ec2_instance[0]' i-abcd1234 #same as above, imports a real-world resource into an instance of Terraform resource  
> terraform output #list all outputs as stated in code  
> terraform output instance_public_ip # list out a specific declared output  
> terraform output -json #list all outputs in JSON format  

##### Terraform Cloud  
> terraform login #obtain and save API token for Terraform cloud  
> terraform logout #Log out of Terraform Cloud, defaults to hostname app.terraform.io

#### Terraform search
> terraform state show
> terraform state list
> terraform show
> terraform show list
> terraform console
> terraform fmt # used to rewrite Terraform configuration files to a canonical format and style.
> terraform validate # because it is used to validate the terraform configuration. 
>  terraform show # how is used to provide human-readable output from a state or plan file
> terraform force-unlock LOCK_ID