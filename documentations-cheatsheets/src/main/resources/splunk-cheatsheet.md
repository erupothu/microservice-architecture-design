

__Install Splunk__

wget -O splunk-8.2.1-ddff1c41e5cf-linux-2.6-amd64.deb 'https://www.splunk.com/page/download_track?file=8.2.1/linux/splunk-8.2.1-ddff1c41e5cf-linux-2.6-amd64.deb&ac=&wget=true&name=wget&platform=Linux&architecture=x86_64&version=8.2.1&product=splunk&typed=release'

sudo apt install ./splunk-*-amd64.deb

sudo /opt/splunk/bin/splunk enable boot-start

__Uninstall Splunk__

sudo /opt/splunk/bin/splunk disable boot-start
sudo apt remove splunk