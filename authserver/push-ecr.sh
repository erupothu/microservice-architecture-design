#!/bin/bash

mvn clean install

docker build -f Dockerfile -t dev-server-oauth .

aws ecr get-login-password --region ap-south-1 | docker login --username AWS --password-stdin 470702883802.dkr.ecr.ap-south-1.amazonaws.com

docker tag dev-server-oauth:latest 470702883802.dkr.ecr.ap-south-1.amazonaws.com/dev-server-oauth:latest

docker push 470702883802.dkr.ecr.ap-south-1.amazonaws.com/dev-server-oauth:latest