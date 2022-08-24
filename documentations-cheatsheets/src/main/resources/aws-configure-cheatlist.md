
~/.aws/credentials  
~/.aws/config  


aws configure  

aws configure set region us-west-2 --profile integ  
aws configure set cli_pager "" --profile integ  
aws configure get region --profile integ  
aws configure import --csv file://credentials.csv  
aws configure list  
aws configure list-profiles  