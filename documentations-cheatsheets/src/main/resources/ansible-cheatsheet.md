
##### master Node
$ sudo apt-get update  
$ sudo apt-get install software-properties-common  
$ sudo apt-add-repository ppa:ansible/ansible $ sudo apt-get update  
$ sudo apt-get install ansible  
$ ssh-keygen
$ cd .ssh
$ cat id_rsa.pub #copy this key to slave node

##### Slave Node

$ cd .ssh
$ nano authorized-keys # Add master id_rsa.pub key into this file

##### Master Node 
$ ssh ubuntu@slave_ip (Directly connect to slave without .pem key or username and password)

##### Master Node Ansible

$ nano /etc/ansible/hosts
[production]
slave1 ansible_user=ubuntu ansible_ssh_host=15.207.95.43 # we can add private key also -ansible_ssh_private_key_file=/Users/k/.ssh/id_rsa

[myservers]
3.93.171.48 ansible_user=ubuntu ansible_ssh_private_key_file=/Users/kihyuckhong/.ssh/einsteinish.pem

$ ansible-inventory --list -y
$ ansible -m ping all (connect to all slaves)
$ ansible -m ping slave1 (connect to slave1)
$ ansible -i hosts -m ping myservers
$ ansible -i hosts dev -m ping
$ ansible all -m ping -u ubuntu

##### Ad-hoc commands

$ ansible all -m apt -a "name=vim state=latest" -u root
$ ansible servers -a "uptime" -u root
$ ansible all -a "df -h" -u root
$ ansible server1:server2 -m ping -u root

#### Playbook 

$ nano hello.sh

```
#!/bin/sh

echo hello world > /var/www/html/1.html
```

$ nano ans_apache_inst.yml

```
---

 - hosts: slave1
   become: yes
   name: apache
   tasks:
    - name: Install apache
      apt: name=apache2 state=latest
    - name: Add page
      script: hello.sh

```

##### 
$ ansible all -m ping -u sammy
$ ansible-playbook myplaybook.yml -u sammy

##### Using a Custom SSH Key

$ ansible all -m ping --private-key=~/.ssh/custom_id
$ ansible-playbook myplaybook.yml --private-key=~/.ssh/custom_id
$ ansible all -m ping --ask-pass
$ ansible-playbook myplaybook.yml --ask-pass
$ ansible all -m ping --ask-become-pass
$ ansible-playbook myplaybook.yml --ask-become-pass

$ ansible-playbook ans_apache_inst.yml
$ ansible all -m ping -i digital_ocean.py

##### Controlling Playbook Execution

$ ansible-playbook myplaybook.yml --start-at-task="Set Up Nginx"
$ ansible-playbook myplaybook.yml --tags=mysql,nginx

$ ansible-playbook myplaybook.yml

##### Getting Information about a Play

$ ansible-playbook myplaybook.yml --list-tasks

##### Using Ansible Vault to Store Sensitive Data
$ ansible-vault create credentials.yml

$ ansible-vault encrypt credentials.yml

##### Viewing the Contents of an Encrypted File

$ ansible-vault view credentials.yml
$ ansible-vault edit credentials.yml
$ ansible-vault decrypt credentials.yml

##### Using Multiple Vault Passwords

$ ansible-vault create --vault-id dev@prompt credentials_dev.yml
$ ansible-vault create --vault-id prod@prompt credentials_prod.yml
$ ansible-vault edit credentials_dev.yml --vault-id dev@prompt
$ ansible-vault create --vault-id dev@path/to/passfile credentials_dev.yml

##### Running a Playbook with Data Encrypted via Ansible Vault

$ ansible-playbook myplaybook.yml --ask-vault-pass
$ ansible-playbook myplaybook.yml --vault-password-file my_vault_password.py
$ ansible-playbook myplaybook.yml --vault-id dev@prompt
$ ansible-playbook myplaybook.yml --vault-id dev@vault_password.py
$ ansible-playbook myplaybook.yml --vault-id dev@vault_password.py --vault-id test@prompt --vault-id ci@prompt

##### Debugging
$ ansible-playbook myplaybook.yml -v
$ ansible-playbook myplaybook.yml -vvvv


##### verify in Slave server and check in browser
> http://ip_address
> htt://ip_address/1.html




