#### <p align="center"> Terraform </p>

<h1> what is Terraform? </h1>
            <p> 
            Terraform is a open source Infrastructure as a Code Tool that lets you define work on cloud <b>(AWS, Azure, GCP etc) </b> and on-premises. It is use to manage all your infrasture thoughout its life cycle. Terraform can manage low level component and high level components like <b> compute, storage, network </b> resources.
            </p>
            
<h1> How Does Terraform work </h1>
            

<img src="https://mktg-content-api-hashicorp.vercel.app/api/assets?product=tutorials&version=main&asset=public%2Fimg%2Fterraform%2Fterraform-iac.png" alt="Markdown Monster icon" height="50%" width="100%" style="float: left; margin-right: 10px;" />
             
<div>



Terraform creates and manages resources on the cloud platform and other services. 
* AWS  
            	    * Terraform can craete EC2 instance with defined configurations and Deploy Applications with Kubernates, Helm charts and manages applications.  
            	    * Terraform can create VPC with subnets, security group with defined configurations and manages if changes requied.  
            	    * Terraform can create EKS cluster with worker nodes(EC2 Instances), Autoscale them and Deploy Applications using Helm charts, kubernates and manages.  
            	    * Teraform can create EMR Cluster with spark, Hive, Hadoop with defined configurations and can Deploy applications into EMR.  
            	    * Terraform can create S3 bucket with security configurations and manages the storage files.  
</div>

       
<h1> Why Terraform? </h1>

* Open Source
* Infrastructure as Code. Easy to write modular scripts.
* Support for JSON.
* A tool for building, changing, and versioning infrastructure safely and efficiently. 
* AWS Partner Network (APN) Advanced Technology Partner and member of the AWS DevOps Competency which makes Terraform up to date.
* Can work for multiple providers(AWS, Azure, Databricks etc) in the same config script.
* Terraform keeps its state in a file.
* Simple Steps: write code -> Init -> Validate -> Plan -> Apply -> Destroy
   * Write tf Code – this is where you create changes to the code for infra.
   * Init – this is where you initialize your code to download the requirements mentioned in your code.
   * Validate – validate the syntax/error in the codes.
   * Plan – this is where you review changes and choose whether to simply accept them.
   * Apply – this is where you accept changes and apply them against real infrastructure.
   * Destroy – this is where to destroy all your created infrastructure.
   * State File – Terraform maintains the state of the infrastructure created last time.

* __Manage any infrastructure__
    * Find providers for many of the platforms and services you already use in the Terraform Registry.
    * Does orchestration, not just configuration management
    * Supports multiple providers such as AWS, Azure, GCP, DigitalOcean and many more
    * Easily portable to any other provider
    * Supports Client only architecture, so no need for additional configuration management on a server  
    

* __Track your infrastructure__
    * Terraform generates a plan and prompts you for your approval before modifying your infrastructure. 
    * It also keeps track of your real infrastructure in a state file, which acts as a source of truth for your environment. 
    * Terraform uses the state file to determine the changes to make to your infrastructure so that it will match your configuration.
   
 
* __Automate changes__  
    * Terraform configuration files are declarative, meaning that they describe the end state of your infrastructure. 
    * Terraform builds a resource graph to determine resource dependencies and creates or modifies non-dependent resources in parallel. 
    
    
* __Standardize configurations__
    * Terraform supports reusable configuration components called modules that define configurable collections of infrastructure, saving time and encouraging best practices. 
    * You can use publicly available modules from the Terraform Registry, or write your own
    
    
* __Collaborate__
    * ince your configuration is written in a file, you can commit it to a Version Control System (VCS) and use Terraform Cloud to efficiently manage Terraform workflows across teams. 
    * Terraform Cloud runs Terraform in a consistent, reliable environment and provides secure access to shared state and secret data, role-based access controls, a private registry for sharing both modules and providers, and more.
    
    
* __Multi-Cloud Deployment__
    * Terraform lets you use the same workflow to manage multiple providers and handle cross-cloud dependencies. 
    * This simplifies management and orchestration for large-scale, multi-cloud infrastructures.
 
 
* __Application Infrastructure Deployment, Scaling, and Monitoring Tools__
    * You can use Terraform to efficiently deploy, release, scale, and monitor infrastructure for multi-tier applications.
    * Terraform allows you to manage the resources in each tier together, and automatically handles dependencies between tiers
    * For example, Terraform will deploy a database tier before provisioning the web servers that depend on it.
    
    
* __Policy Compliance and Management__
    * Terraform can help you enforce policies on the types of resources teams can provision and use. 
    * you can use Sentinel, a policy-as-code framework, to automatically enforce compliance and governance policies before Terraform makes infrastructure changes. 
    * Sentinel is available with the Terraform Cloud team and governance tier.
    
    
* __Parallel Environments__
    * You may have staging or QA environments that you use to test new applications before releasing them in production.
    * Terraform lets you rapidly spin up and decommission infrastructure for development, test, QA, and production. 
    * Using Terraform to create disposable environments as needed is more cost-efficient than maintaining each one indefinitely.
    
    
<h1> Fundamentas </h1>

* __Modules__
    * Create and use Terraform modules to organize your configuration. 
    * Host a static website in AWS using two modules: one from the Terraform Registry and one you will build yourself. 


* __Provision__
    * Install software, edit files, and provision machines created with Terraform.
    
    
* __Terraform state__


* __Terraform cloud__
    * Collaborate on infrastructure with Terraform Cloud. 
    
    
<h1> Core Concepts </h1>

* __Providers__
     * It is a plugin to interact with APIs of service and access its related resources.
     * A provider works pretty much as an operating system's device driver.
     * It exposes a set of resource types using a common abstraction, thus masking the details of how to create, modify, and destroy a resource pretty much transparent to users. 
     * Terraform downloads providers automatically from its public registry as needed, based on the resources of a given project.


```json 
     provider "kubernetes" {
  		version = "~> 1.10"
	 }
```

* __Resources__
    * It refers to a block of one or more infrastructure objects (compute instances, virtual networks, etc.), which are used in configuring and managing the infrastructure.
    * In Terraform, a resource is anything that can be a target for CRUD operations in the context of a given provider.
    * Some examples are an EC2 instance, an Azure MariaDB, or a DNS entry.
    
```json
resource "aws_instance" "web" {
  ami = "some-ami-id"
  instance_type = "t2.micro"
}
```

* __count and for_each Meta Arguments__
    * The count and for_each meta arguments allow us to create multiple instances of any resource
    * The main difference between them is that count expects a non-negative number, whereas for_each accepts a list or map of values.
    
```json
resource "aws_instance" "server" {
  count = var.server_count 
  ami = "ami-xxxxxxx"
  instance_type = "t2.micro"
  tags = {
    Name = "WebServer - ${count.index}"
  }
}
```

```json
variable "instances" {
  type = map(string)
}
resource "aws_instance" "server" {
  for_each = var.instances 
  ami = each.value
  instance_type = "t2.micro"
  tags = {
    Name = each.key
  }
}
```

* __Data Sources__
    * It is implemented by providers to return information on external objects to terraform.
    * Data sources work pretty much as “read-only” resources,in the sense that we can get information about existing ones but can't create or change them. 
    *  They are usually used to fetch parameters needed to create other resources.
    * This example defines a data source called “ubuntu” that queries the AMI registry and returns several attributes related to the located image.
    * We can then use those attributes in other resource definitions, prepending the data prefix to the attribute name:
    
```json
data "aws_ami" "ubuntu" {
  most_recent = true
  filter {
    name   = "name"
    values = ["ubuntu/images/hvm-ssd/ubuntu-trusty-14.04-amd64-server-*"]
  }
  filter {
    name   = "virtualization-type"
    values = ["hvm"]
  }
  owners = ["099720109477"] # Canonical
}
```

```json
resource "aws_instance" "web" {
  ami = data.aws_ami.ubuntu.id 
  instance_type = "t2.micro"
}
```

* __State__
    * It consists of cached information about the infrastructure managed by Terraform and the related configurations.
    * The state of a Terraform project is a file that stores all details about resources that were created in the context of a given project. 
    * For instance, if we declare an azure_resourcegroup resource in our project and run Terraform, the state file will store its identifier.
    * The primary purpose of the state file is to provide information about already existing resources, so when we modify our resource definitions, Terraform can figure out what it needs to do.
    * An important point about state files is that they may contain sensitive information. Examples include initial passwords used to create a database, private keys, and so on.
    * Terraform uses the concept of a backend to store and retrieve state files. The default backend is the local backend, which uses a file in the project's root folder as its storage location. 
    * We can also configure an alternative remote backend by declaring it in a terraform block in one of the project's .tf files:
    
```json
terraform {
  backend "s3" {
    bucket = "some-bucket"
    key = "some-storage-key"
    region = "us-east-1"
  }
}
```

* __Modules__
    * It is a folder with Terraform templates where all the configurations are defined
    * Terraform modules are the main feature that allows us to reuse resource definitions across multiple projects or simply have a better organization in a single project. 
    * This is much like what we do in standard programming: instead of a single file containing all code, we organize our code across multiple files and packages.
    * A module is just a directory containing one or more resource definition files.even when we put all our code in a single file/directory, we're still using modules
    * The important point is that sub-directories are not included as part of a module. Instead, the parent module must explicitly include them using the module.
    * Here we're referencing a module located at the “networking” sub-directory and passing a single parameter to it, a boolean value in this case.
    
```json
module "networking" {
  source = "./networking"
  create_public_ip = true
}
```

* __Input Variables__
    * Any module, including the top, or main one, can define several input variables using variable block definitions:
    * A variable has a type, which can be a string, map, or set, among others.
    *  It also may have a default value and description.
        * -var command-line option
        * .tfvar files, using command-line options or scanning for well-known files/locations
        * Environment variables starting with TF_VAR_
        * The variable's default value, if present
        
```json
variable "myvar" {
  type = string
  default = "Some Value"
  description = "MyVar description"
}
```

```json
resource "xxx_type" "some_name" {
  arg = var.myvar
}
```

* __Output Values__
    * These are return values of a terraform module that can be used by other configurations.
    * By design, a module's consumer has no access to any resources created within the module.
    * Sometimes, however, we need some of those attributes to use as input for another module or resource.
    * To address those cases, a module can define output blocks that expose a subset of the created resources:
    * Here we're defining an output value named “web_addr” containing the IP address of an EC2 instance that our module created. 
    * Now any module that references our module can use this value in expressions as module.module_name.web_addr
    
```json
output "web_addr" {
  value = aws_instance.web.private_ip
  description = "Web server's private IP address"
}
```

* __Local Variables__
    * Local variables work like standard variables, but their scope is limited to the module where they're declared.
    * The use of local variables tends to reduce code repetition, especially when dealing with output values from modules:
    * Here, the local variable vpc_id receives the value of an output variable from the network module.
    * Later, we pass this value as an argument to both service1 and service2 modules.
    
```json
locals {
  vpc_id = module.network.vpc_id
}
module "network" {
  source = "./network"
}
module "service1" {
  source = "./service1"
  vpc_id = local.vpc_id
}
module "service2" {
  source = "./service2"
  vpc_id = local.vpc_id
}
```

* __Workspaces__
    * Terraform workspaces allow us to keep multiple state files for the same project. 
    * When we run Terraform for the first time in a project, the generated state file will go into the default workspace. 
    * Later, we can create a new workspace with the terraform workspace new command, optionally supplying an existing state file as a parameter.
    * We can use workspaces pretty much as we'd use branches in a regular VCS. 
    * For instance, we can have one workspace for each target environment – DEV, QA, PROD
    * and, by switching workspaces, we can terraform apply changes as we add new resources.
    * workspaces are an excellent choice to manage multiple versions
    * This is great news for everyone who's had to deal with the infamous “works in my environment” problem, as it allows us to ensure that all environments look the same.
    * we can use the terraform.workspace predefined variable
    * This variable contains the name of the current workspace, and we can use it as any other in expressions.
    
<h1> Terraform Life Cycle </h1>

* __init__
    * Terraform scans our project files and downloads any required provider.
    * Terraform init initializes the working directory which consists of all the configuration files

* __Plan__
    * Terraform plan is used to create an execution plan to reach a desired state of the infrastructure. 
    * Changes in the configuration files are done in order to achieve the desired state.
    * It is one of the stages where it determines what needs to be created, updated, or destroyed to move from real/current state of the infrastructure to the desired state.
    * we use the plan command to verify what actions Terraform will perform to create our resources.
    * Terraform is telling us that it needs to create a new resource, which is expected as it doesn't exist yet. 
    
* __Apply__
    * Terraform apply then makes the changes in the infrastructure as defined in the plan, and the infrastructure comes to the desired state.
    *It is one of the stages where it applies the changes real/current state of the infrastructure in order to move to the desired state.
    * Terraform apply will applies actual resource creation using the apply command:
    
* __ destory__
    * Terraform destroy is used to delete all the old infrastructure resources, which are marked tainted after the apply phase.
    
    
<h1> sample Project </h1>

* The main.tf file

```
$ cd $HOME
$ mkdir hello-terraform
$ cd hello-terraform
$ cat > main.tf <<EOF
provider "local" {
  version = "~> 1.4"
}
resource "local_file" "hello" {
  content = "Hello, Terraform"
  filename = "hello.txt"
}
EOF
```

> $ terraform init

> terraform plan

> terraform apply

> $ cat hello.txt

> terraform apply -auto-approve

> echo foo > hello.txt

> $ terraform plan

> terraform apply -auto-approve

<h1> What is Terraform Cloud? </h1>

* Terraform Cloud is an application that manages Terraform runs in a consistent and reliable environment instead of on your local machine.
*  It stores shared state and secret data, and connects to version control systems so that you and your team can work on infrastructure as code within your usual code workflow. 
*  It also has a private registry for sharing Terraform modules.

<img src="https://mktg-content-api-hashicorp.vercel.app/api/assets?product=tutorials&version=main&asset=public%2Fimg%2Fterraform%2Fcloud%2Foverview.png" height="50%" width="100%" >

* The VCS-driven workflow
    * A workspace contains Terraform configuration files, environment variables, 
    * Terraform input variables, and state files — everything Terraform needs to manage a given collection of infrastructure. 
    * Write configuration - Create or update Terraform configuration, which represents your infrastructure in HashiCorp Configuration Language
    * Commit changes to version control - Check your configuration files into a version control system (VCS) as the source of truth for your configuration.
    * Select a workspace - Connect the VCS repo containing your configuration to a new or existing Terraform Cloud workspace.
    * Configure variables - Define your workspace's Terraform variables and environment variables. These are any values you want your configuration's end users to customize, and credentials or other sensitive values.
    * Plan & apply - Execute Terraform Cloud runs (plans and applies) to manage your infrastructure. You can trigger these via the Terraform Cloud UI or by opening pull requests in your VCS.
    
* Create an account
    * Visit https://app.terraform.io/signup/account and follow the prompts to create a free Terraform Cloud account.
    
* Create an organization
    * Your organization is free, and the members you add will be able to collaborate on your workspaces and share private modules.
    * Enter an organization name and email address. You can use the same email address that you used for your account.

* Create a Workspace
    * Once you have created a Terraform Cloud account and created or joined an organization, you can start managing version-controlled infrastructure with Terraform Cloud.
    
* Connect Terraform cloud to Github and Choose a repository
    * Terraform will display a list of your GitHub repositories. Choose the repository you forked, called "tfc-guide-example". If you have many GitHub repositories, you may need to filter the list to find the correct one.  

* Create a variable set
    * You can define both input variables and environment variables in variable sets. Input variables define the values for variables you reference in your configuration, while environment variables typically store provider credentials or modify Terraform's behavior, such as logging verbosity.
    * To create a variable set, click on Settings in the top menu bar, then Variable sets in the left side bar.
    
    
<h1> Terraform install </h1>

> sudo apt-get update && sudo apt-get install -y gnupg software-properties-common curl  
> curl -fsSL https://apt.releases.hashicorp.com/gpg | sudo apt-key add -  
> sudo apt-add-repository "deb [arch=amd64] https://apt.releases.hashicorp.com $(lsb_release -cs) main"  
> sudo apt-get update && sudo apt-get install terraform  
> terraform --version  
> terraform --help  
> terraform -help plan  
> terraform -install-autocomplete  
