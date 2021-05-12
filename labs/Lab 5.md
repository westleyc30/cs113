# Lab 5
## 2.5 Programming
```java
	// a.
	Node<String> nodeRef = head;
	Node<String> bill = new Node<>("Bill");
	while (nodeRef.next != null) {
		if (nodeRef.next = "Tom") {
			bill.next = tom;
			nodeRef.next = bill;
			break;
		}
	}
	// b.
	while (nodeRef.next != null) {
		if (nodeRef.next = "Sam") {
			sue.next = sam;
			nodeRef.next = sue;
			break;
		}
	}
	
	// c.
	while (nodeRef.next != null) {
		if (nodeRef.next = "Bill") {
			nodeRef.next = bill.next;
			break;
		}
	}
	// d. 
	names.remove("Sam");
	while (nodeRef.next != null) {
		if (nodeRef.next = "Sam") {
			nodeRef.next = sam.next;
			break;
		}
	}
```

## 2.5 Self-Check
1. O(n)
2. O(n)
3. add methods
	1. add to front O(1)
	2. add at index O(N)
4.
```java
int sum = 0;
Node<Integer> nodeRef = head;
while (nodeRef.next != null) {
	int next = nodeRef.next;
	sum += next;
	nodeRef = nodeRef.next;
}
```


5a. creates a new headnode with named shakira and sets its next to the current heads next

5b. deletes nodeRef.next from the list

5c. Traverses list until end then adds "Tamika" to the end

5d. Traverses list changes nodeRef Data to "Sally" adds "Harry" after "Sally node"