for x in $(seq 1 10)
do
	echo $x
	#timeout 10 "java ${KnightBoard $x $x}"
	java SilverDriver makelake.$x.in
	cat makelake.$x.out
done
