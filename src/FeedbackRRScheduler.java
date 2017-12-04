import java.util.PriorityQueue;
import java.util.Properties;
import java.util.Queue;

/**
 * Round Robin Scheduler
 * 
 * @version 2017
 */
public class FeedbackRRScheduler extends AbstractScheduler {

  private Queue<Process> readyQueue;
  int quantum;
    
  public FeedbackRRScheduler() {
      readyQueue = new PriorityQueue<>();
      
  }
  
  /**
   * Initializes the scheduler from the given parameters
   */
  @Override
  public void initialize(Properties parameters) {
      quantum = Integer.parseInt(parameters.getProperty("timeQuantum"));
  }

  /**
   * Adds a process to the ready queue.
   * usedFullTimeQuantum is true if process is being moved to ready
   * after having fully used its time quantum.
   */
  @Override
  public void ready(Process process, boolean usedFullTimeQuantum) {
      if(usedFullTimeQuantum){
          process.setPriority(process.getPriority()+1);
      }
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
  
  public int getTimeQuantum() { 
      return quantum;
  }
  
  public boolean isPreemptive() {
    return true;
  }
}
