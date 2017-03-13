echo "*"
echo "********"
echo "*BRONZE*"
echo "********"
echo ""
for x in $(seq 1 10)
do
    java BronzeDriver makelake.$x.in
    cat makelake.$x.out
done

echo "*"
echo "********"
echo "*SILVER*"
echo "********"
echo ""
for x in $(seq 1 10)
do
    echo "Silver" $x
    echo ""
    java SilverDriver ctravel.$x.in
    cat ctravel.$x.out
    echo ""
done
