import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Properties;
import java.util.Queue;

/**
 * Ideal Shortest Job First Scheduler
 * 
 * @version 2017
 */
public class SJFScheduler extends AbstractScheduler {

    
  private Queue<Process> readyQueue;
  int initialBurst;
  float alphaBurst;  
  
  public SJFScheduler(){
      readyQueue = new PriorityQueue<>();
      
  }
  
  @Override
  public void initialize(Properties parameters) {
      initialBurst=Integer.parseInt(parameters.getProperty("initialBurstEstimate"));
      alphaBurst=Float.parseFloat(parameters.getProperty("alphaBurstEstimate"));
  }

  /**
   * Adds a process to the ready queue.
   * usedFullTimeQuantum is true if process is being moved to ready
   * after having fully used its time quantum.
   */
  @Override
  public void ready(Process process, boolean usedFullTimeQuantum) {
        if (process.getRecentBurst()!=-1){
            process.setPriority((int) ((alphaBurst*process.getRecentBurst())+((1-alphaBurst)*process.getPriority())));
        }
        else {
            process.setPriority((int) ((alphaBurst*initialBurst)+(1-alphaBurst)*initialBurst));
        }
        System.out.println("Process " + process + " priority: " + process.getPriority());
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
