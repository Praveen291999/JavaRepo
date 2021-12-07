package com.dnapass.training.java.transaction;


import java.util.*;

public class TransactionService {
	static List<Transaction> TransactionsDatabase = new ArrayList<Transaction>();
	static {
		TransactionsDatabase = DataLoader.newTransactions();

	}

	public void create(Transaction tran) {
		// System.out.println(tran.getId().TYPE+" "+tran.getType()+"
		// "+tran.getAmount().TYPE+" "+tran.getCity()+" "+tran.getCurrency());
		TransactionsDatabase.add(tran);
	}

	public void delete(Transaction tran) {
		TransactionsDatabase.remove(tran);
	}

	public boolean find(Transaction tran) {

		return TransactionsDatabase.contains(tran);
	}

	public boolean update(Transaction tran) {
		int flag = 0;
		for (Transaction s : TransactionsDatabase) {
			// System.out.print("Update id :"+tran.getId()+" " +s.getId()+" "
			// +((int)s.getId()==(int)tran.getId()));
			if ((int) s.getId() == (int) tran.getId()) {
				System.out.print("Update id :" + tran.getId() + s.getId());
				s.setType(tran.getType());
				s.setAmount(tran.getAmount());
				s.setCity(tran.getCity());
				s.setCurrency(tran.getCurrency());
				flag = 1;

			}
		}
		if (flag == 1)
			return true;
		else
			return false;
	}

	public void ShowTransactions() {
		for (Transaction e : TransactionsDatabase) {
			System.out.println(e.id + " " + e.type + " " + e.amount + " " + e.city + " " + e.currency);
		}
	}

	public boolean removeDuplicate() {
		Set<Transaction> set = new HashSet<Transaction>(TransactionsDatabase);
//		for(Transaction e:set) {
//			System.out.println(e.id+" "+e.type+" "+e.amount+" "+e.city+" "+e.currency);
//		}
		TransactionsDatabase.clear();
		TransactionsDatabase.addAll(set);
		return true;
	}

	public boolean swapTransactions(Integer initial, Integer Final) {
		Collections.swap(TransactionsDatabase, initial, Final);
		return true;
	}

	public boolean findById(Integer id) {
		for (Transaction s : TransactionsDatabase) {
			// System.out.print("Update id :"+tran.getId()+" " +s.getId()+" "
			// +((int)s.getId()==(int)tran.getId()));
			if ((int) s.getId() == (int) id) {
				System.out.println(s.id + " " + s.type + " " + s.amount + " " + s.city + " " + s.currency);
			}
		}
		return false;
	}

	public boolean newTransaction(Integer initial, Integer Final) {
		List<Transaction> newTransactiondb = new ArrayList<Transaction>();
		newTransactiondb.addAll(TransactionsDatabase.subList(initial, Final + 1));
		for (Transaction e : newTransactiondb) {
			System.out.println(e.id + " " + e.type + " " + e.amount + " " + e.city + " " + e.currency);
		}
		return true;
	}

	public boolean replaceProductType(ProductType prod, ProductType prod1) {
		for (Transaction s : TransactionsDatabase) {
			// System.out.print("Update id :"+tran.getId()+" " +s.getId()+" "
			// +((int)s.getId()==(int)tran.getId()));
			if ((ProductType) s.getType() == prod) {
				System.out.println("found");
				s.setType(prod1);
			}
		}
		return true;
	}

	public boolean DeleteByCity(String city) {
		TransactionsDatabase.removeIf(s -> city == s.getCity());
		return false;
	}

	public boolean binarySearch(Transaction tran) {
		Collections.sort(TransactionsDatabase);
		System.out.println(Collections.binarySearch(TransactionsDatabase, tran));
		return true;
	}

	public boolean sortByAmount() {
		Collections.sort(TransactionsDatabase,new AmountComparator());
		return true;
	}
	public boolean sortByCity() {
		Collections.sort(TransactionsDatabase,new CityComparator());
		return true;
	}

	public List<Transaction> findByProductType(ProductType prod) {
		for (Transaction s : TransactionsDatabase) {
			// System.out.print("Update id :"+tran.getId()+" " +s.getId()+" "
			// +((int)s.getId()==(int)tran.getId()));
			if ((ProductType) s.getType() == prod) {
				System.out
						.print("Update id :" + s.id + " " + s.type + " " + s.amount + " " + s.city + " " + s.currency);

			} else
				return null;
		}

		return null;
	}

	public List<Transaction> findByIdAndProductType(Integer id, ProductType prod, String city) {
		for (Transaction s : TransactionsDatabase) {
			// System.out.print("Update id :"+tran.getId()+" " +s.getId()+" "
			// +((int)s.getId()==(int)tran.getId()));
			if (s.getType() == prod && (int) s.getId() == (int) id) {
				System.out
						.print("Update id :" + s.id + " " + s.type + " " + s.amount + " " + s.city + " " + s.currency);

			}
		}
		return null;
	}

}
