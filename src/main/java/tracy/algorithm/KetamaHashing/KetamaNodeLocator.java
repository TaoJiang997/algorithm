package tracy.algorithm.KetamaHashing;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;


public final class KetamaNodeLocator {
	
	private TreeMap<Long, Node> ketamaNodes;
	private HashAlgorithm hashAlg;
	private int numReps = 160;
	
    public KetamaNodeLocator(List<Node> nodes, HashAlgorithm alg, int nodeCopies) {
		hashAlg = alg;
		ketamaNodes=new TreeMap<Long, Node>();
		
        numReps= nodeCopies;
        
		for (Node node : nodes) {
			//每四个虚拟结点为一组
			for (int i = 0; i < numReps / 4; i++) {
				/** Md5是一个16字节长度的数组，将16字节的数组每四个字节一组，
				 分别对应一个虚拟结点，这就是为什么上面把虚拟结点四个划分一组的原因*/
				byte[] digest = hashAlg.computeMd5(node.getName() + i);
				for(int h = 0; h < 4; h++) {
					//对于每四个字节，组成一个long值数值，做为这个虚拟节点的在环中的惟一key
					long m = hashAlg.hash(digest, h);
					ketamaNodes.put(m, node);
				}
			}
		}
    }

	public Node getPrimary(final String k) {
		byte[] digest = hashAlg.computeMd5(k);
		Node rv=getNodeForKey(hashAlg.hash(digest, 0));
		return rv;
	}

	Node getNodeForKey(long hash) {
		final Node rv;
		Long key = hash;
		if(!ketamaNodes.containsKey(key)) {
			SortedMap<Long, Node> tailMap=ketamaNodes.tailMap(key);
			if(tailMap.isEmpty()) {
				key=ketamaNodes.firstKey();
			} else {
				key=tailMap.firstKey();
			}
			//For JDK1.6 version
//			key = ketamaNodes.ceilingKey(key);
//			if (key == null) {
//				key = ketamaNodes.firstKey();
//			}
		}
		
		
		rv=ketamaNodes.get(key);
		return rv;
	}
}
