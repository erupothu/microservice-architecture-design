#!/bin/bash

mvn clean install

docker build -f Dockerfile -t oauth-server .

