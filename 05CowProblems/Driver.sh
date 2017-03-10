for x in $(seq 1 10)
do
	echo $x
	#timeout 10 "java ${KnightBoard $x $x}"
	java USACO makelake.$x.in
	cat makelake.$x.out
done
