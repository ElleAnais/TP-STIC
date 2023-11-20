from socket import *
import time
s=socket(AF_INET,SOCK_STREAM)
host="127.0.0.1"
port=125
s.connect((host,port))
s.send(b'salut moi c le PC client02')
s.close()
