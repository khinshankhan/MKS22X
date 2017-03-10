for x in $(seq 1 10)
do
    echo "Bronze" $x
    echo ""
    java BronzeDriver makelake.$x.in
    cat makelake.$x.out
done

for x in $(seq 1 10)
do
    echo "Silver" $x
    echo ""
    java SilverDriver ctravel.$x.in
    cat ctravel.$x.out
    echo ""
done
