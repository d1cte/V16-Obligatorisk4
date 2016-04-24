package Task3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	 private static Lock lock = new ReentrantLock();
	 private static Condition newDeposit = lock.newCondition();
	 private int balance;
	 
	 Account() {
		 this(0);
	 }
	 
	 Account(int initialBalance) {
		 balance = initialBalance;
	 }
	 
	 public int getBalance() {
		 return balance;
	 }
	 
	 public void withdraw(int amount) {
		 lock.lock();
		 try {
			 while(balance < amount) {
				 System.out.println("\t\t\t\t\t\tVenter på innskudd"); 
				 newDeposit.await();
			 }
			 balance -= amount;
	      }
	      catch (InterruptedException ex) {
	        ex.printStackTrace();
	      }
	      finally {
	        lock.unlock(); 
	      }
	 }

	 public void deposit(int amount) {
		 lock.lock();
		 try {
			 balance += amount;			 
			 newDeposit.signalAll();
		 }
		 finally {
			 lock.unlock();
		 }
	 }

}
