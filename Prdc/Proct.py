import os
import sys
import threading
from M import *
from T1 import *
from T2 import *

def main():
    m=M()
    t1=T1(m)
    t2=T2(m)
    t1.join()
    t2.join()
main()
