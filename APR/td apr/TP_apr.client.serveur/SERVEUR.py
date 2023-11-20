from socket import *
import time
s=socket(AF_INET,SOCK_STREAM)
host="127.0.0.1"
port=125
s.bind((host,port))
s.listen(5)
while True:
    connection,adder=s.accept()
    time.sleep(2)
    data=connection.recv(2340)
    print("message=",data)
    print("j'attend la connexion des clients")  