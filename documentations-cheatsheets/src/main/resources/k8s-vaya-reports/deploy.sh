
kubectl apply -f src/main/resources/k8s-vaya-reports/vaya-reports.yml
kubectl apply -f src/main/resources/k8s-vaya-reports/vaya-reports-service.yml

# kubectl get all
# kubectl logs deployment.apps/vaya-reports-deployment