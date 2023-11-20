from socket import *
import time
s=socket(AF_INET,SOCK_STREAM)
host="127.0.0.1"
port=125
s.connect((host,port))
s.send(b'salut bonjournée ')
s.close()
