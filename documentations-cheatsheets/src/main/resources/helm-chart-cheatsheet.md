
##### 1. create Helm Chart
> helm create <helm-chart-name>
> helm list
##### 2. change values.yaml
image:  
  repository: 470702883802.dkr.ecr.ap-south-1.amazonaws.com/reports-test  
        - containerPort: 8083
imagePullSecrets:
  - name: aws-ecr
##### 3.change in deployment.yaml
              containerPort: 8083
              
##### 4. Deploy chart with app-name
> PASSWORD=$(aws ecr get-login-password 2>&1)
> kubectl create secret docker-registry aws-ecr --docker-server=470702883802.dkr.ecr.ap-south-1.amazonaws.com --docker-username=AWS --docker-password=$PASSWORD --docker-email=harish.e@vayaindia.com
> kubectl get secret
> helm install [app-name] [chart] --set imagePullSecrets[0].name=aws-ecr

##### 5. Uninstall helm
> helm uninstall vaya-reports

##### Important commands
> helm init 
> export HELM_EXPERIMENTAL_OCI=1
> helm pull oci://aws_account_id.dkr.ecr.region.amazonaws.com/helm-test-chart --version 0.1.0
> helm install ecr-chart-demo ./helm-test-chart
> helm get manifest ecr-chart-demo
> kubectl get configmap helm-test-chart-configmap
> helm uninstall ecr-chart-demo

##### Install and Uninstall Apps
> helm install [app-name] [chart]
> helm install [app-name] [chart] --namespace [namespace]
> helm install [app-name] [chart] --values [yaml-file/url]
> helm install [app-name] --dry-run --debug
> helm uninstall [release]

##### Perform App Upgrade and Rollback
> helm upgrade [release] [chart]
> helm upgrade [release] [chart] --atomic
> helm upgrade [release] [chart] --install
> helm upgrade [release] [chart] --version [version-number]
> helm rollback [release] [revision]

> helm get all [release]
> helm get hooks [release]
> helm get manifest [release]
> helm get notes [release]
> helm get values [release]
> helm history [release]

##### Add, Remove, and Update Repositories
> helm repo add [repository-name] [url]
> helm repo remove [repository-name]
> helm repo update

##### List and Search Repositories
> helm repo list
> helm repo index
> helm search [keyword]
> helm search repo [keyword]
> helm search hub [keyword]

##### Release Monitoring
> helm list
> helm list --all-namespaces
> helm list --namespace [namespace]
> helm list --output [format]
> helm status [release]
> helm history [release]
> helm env

##### Plugin Management
> helm plugin install [path/url1] [path/url2] ...
> helm plugin list
> helm plugin update [plugin1] [plugin2] ...
> helm plugin uninstall [plugin]

##### Chart Management
> helm create [name]
> helm package [chart-path]
> helm lint [chart]
> helm show all [chart]
> helm show chart [chart]
> helm show values [chart]
> helm pull [chart]
> helm dependency list [chart]

> helm version

##### Helm Template for Debug
> helm template [NAME] [CHART]
> helm template my-app-instance sourcerepo/my-app
> helm template my-app-instance .

