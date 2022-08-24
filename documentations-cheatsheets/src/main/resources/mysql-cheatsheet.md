
* __how the replication status using__  
    * SHOW SLAVE STATUS
    * SHOW MASTER STATUS
    * SHOW SLAVE HOSTS;  


* __List Databases/Tables/Colums__
    * show databases;
    * show tables;
    * describe table;
    * use database;
    * show variables;
    * show variables like '';
    * SHOW VARIABLES LIKE 'have_query_cache';
    * SHOW STATUS LIKE 'Qcache%';
    * set global variable_name='';
    * set global net_write_timeout = 100000;
    * set global net_read_timeout = 100000;  

 
* __Remote MySQL Dump and Import__
    * Mysql


* __Troubleshooting__
    * mysqladmin flush-hosts;
    * Stop MySQL
    * Remove /var/lib/mysql/relay-log-index.*
    * Start MySQL  
    

* __Check for currently running MySQL queries__  
    * show processlist;
    * show full processlist;  


* __Find top long running queries__
    * SELECT id,host,state,command,time,left(replace(info,'\n','<lf>'),120) FROM information_schema.processlist WHERE command <> 'Sleep' AND info NOT LIKE '%PROCESSLIST%' ORDER BY time DESC LIMIT 25; 
    * kill id;    # Kill running queries by id from process listing  


* __Show Recent Commands__
    * SHOW BINLOG EVENTS;
    * SHOW BINLOG EVENTS IN '<some bin file name>';  


* __Changing Replication Format__
    * FLUSH TABLES WITH READ LOCK; # Make master read-only by running
    * FLUSH LOGS;
    * UNLOCK TABLES;  
    

* __Fix Slow Replication__
    * set global query_cache_size=0;  
    
    
    