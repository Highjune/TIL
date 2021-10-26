# Redis 설치
```
sudo apt-get install redis-server

sudo vim /etc/redis/redis.conf
> #bind 127.0.0.1
> requirepass test!
> port 63179

sudo service redis-server restart
```

