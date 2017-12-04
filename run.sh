#This file will run the experiments iteratively. Experiment outputs will be placed inside the output folder.
cd src

#Loop to generate the input parameters for the first experiment.
for i in {1..3}
do
	java InputGenerator ../experiment1/seed$i/input_parameters.prp ../experiment1/seed$i/feedbackRR/inputs.in
	java InputGenerator ../experiment1/seed$i/input_parameters.prp ../experiment1/seed$i/RR/inputs.in
done

#Embedded for loop to run the first experiment
for i in {1..3}
do
	for j in {1..6}
	do
		java Simulator ../experiment1/seed$i/feedbackRR/simulator_parameters$j.prp ../output/experiment1/seed$i/FBRRoutput$j.out ../experiment1/seed$i/feedbackRR/inputs.in
		java Simulator ../experiment1/seed$i/RR/simulator_parameters$j.prp ../output/experiment1/seed$i/RRoutput$j.out ../experiment1/seed$i/RR/inputs.in

	done
done

#Embedded for loop to generate the input parameters for the second experiment
for i in {1..3}
do
	for j in {1..6}
	do
		java InputGenerator ../experiment2/seed$i/sjf/input_parameters$j.prp ../experiment2/seed$i/sjf/inputs$j.in
		java InputGenerator ../experiment2/seed$i/isjf/input_parameters$j.prp ../experiment2/seed$i/isjf/inputs$j.in
	done
done

#Embedded for loop to run the second experiment
for i in {1..3}
do
        for j in {1..6}
        do
                java Simulator ../experiment2/seed$i/sjf/simulator_parameters.prp ../output/experiment2/seed$i/SJFoutput$j.out ../experiment2/seed$i/sjf/inputs$j.in
                java Simulator ../experiment2/seed$i/isjf/simulator_parameters.prp ../output/experiment2/seed$i/ISJFoutput$j.out ../experiment2/seed$i/isjf/inputs$j.in

        done
done

#Embedded for loop to generate the input parameters for the third experiment
for i in {1..3}
do
        for j in {1..6}
        do
                java InputGenerator ../experiment3/seed$i/sjf/input_parameters$j.prp ../experiment3/seed$i/sjf/inputs$j.in
                java InputGenerator ../experiment3/seed$i/rr/input_parameters$j.prp ../experiment3/seed$i/rr/inputs$j.in
		java InputGenerator ../experiment3/seed$i/fcfs/input_parameters$j.prp ../experiment3/seed$i/fcfs/inputs$j.in
        done
done

#Embedded for loop to run the third experiment
for i in {1..3}
do
        for j in {1..6}
        do
                java Simulator ../experiment3/seed$i/sjf/simulator_parameters.prp ../output/experiment3/seed$i/SJFoutput$j.out ../experiment3/seed$i/sjf/inputs$j.in
                java Simulator ../experiment3/seed$i/rr/simulator_parameters.prp ../output/experiment3/seed$i/RRoutput$j.out ../experiment3/seed$i/rr/inputs$j.in
		java Simulator ../experiment3/seed$i/fcfs/simulator_parameters.prp ../output/experiment3/seed$i/FCFSoutput$j.out ../experiment3/seed$i/fcfs/inputs$j.in
        done
done





