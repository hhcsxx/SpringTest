package net.chuangdie.lhb.bean;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class ComImpl implements Com
{
	private TransactionTemplate transactionTemplate;

	public void insertAll(Shopping shopping, Transaction trans) throws Exception
	{
		shopping.insert(shopping);
		trans.insert(trans);
	}

	public void enrollStudentInCourse(final Shopping shopping, final Transaction trans)
	{
		transactionTemplate.execute(new TransactionCallback()
		{
			public Object doInTransaction(TransactionStatus ts)
			{
				try
				{
					shopping.insert(shopping);
					trans.insert(trans);
				} catch (Exception e)
				{
					ts.setRollbackOnly();
				}
				return null;
			}
		});
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate)
	{
		this.transactionTemplate = transactionTemplate;
	}

}
