

aws s3 ls                  # List all buckets  
aws s3 ls s3://<bucket>    # List content of a bucket  
aws s3 mb s3://<bucket>    # Create a bucket  
  
aws s3 cp <path> s3://<bucket>      # Copy into bucket  
aws s3 cp s3://<bucket> <path>      # Copy from bucket  
  
aws mv s3://<bucket>/<src> <dest>   # Move within bucket  
  
aws s3 rb s3://<bucket>          # Remove empty bucket  
aws s3 rm s3://<bucket>/<path>   # Remove object from bucket  

aws s3 sync s3://bucket-1 s3://bucket-2  