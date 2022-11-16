import threading, time, random
 
mutex = threading.Lock()
class thread_one(threading.Thread):
	def run(self):
		global mutex
		print ("A Thread 1 está dormindo \n")
		time.sleep(random.randint(1, 5))
		print("Thread 1 finalizada \n")
		mutex.release()
 
class thread_two(threading.Thread):
	def run(self):
		global mutex
		print ("A Thread 2 está dormindo \n")
		time.sleep(random.randint(1, 5))
		mutex.acquire()
		print("Thread 2 finalizada \n")
  
mutex.acquire()
t1 = thread_one()
t2 = thread_two()
t1.start()
t2.start()""