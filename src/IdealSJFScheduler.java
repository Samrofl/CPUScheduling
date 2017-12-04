import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Ideal Shortest Job First Scheduler
 * 
 * @version 2017
 */
public class IdealSJFScheduler extends AbstractScheduler {

    
  private Queue<Process> readyQueue;
  
  public IdealSJFScheduler(){
      readyQueue = new PriorityQueue<>();
      
  }

  /**
   * Adds a process to the ready queue.
   * usedFullTimeQuantum is true if process is being moved to ready
   * after having fully used its time quantum.
   */
  public void ready(Process process, boolean usedFullTimeQuantum) {
        process.setPriority(process.getNextBurst());
        readyQueue.offer(process);
      
  }

  /**
   * Removes the next process to be run from the ready queue 
   * and returns it. 
   * Returns null if there is no process to run.
   */
  @Override
  public Process schedule() {
      System.out.println("Scheduler selects process "+readyQueue.peek());
      return readyQueue.poll();
  }
}
