import os
import sys
import threading
import time
import random
from M import *

class T2(threading.Thread):
    def __init__(self,m):
        threading.Thread.__init__(self)
        self.m=m
        self.lock=threading.Lock()
        self.start()
    def run(self):
        while(1):
            time.sleep(random.randint(1,5))
            self.lock.acquire()
            print("\t\t\tT2 m=" + str(self.m.aumenta(self.m)) + "\n")
            self.lock.release()
