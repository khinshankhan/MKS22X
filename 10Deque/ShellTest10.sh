for i in $(seq 0 6)
do
	 for x in $(seq 0 100)
	 do
	     java Test10 $i $x
	 done
done
