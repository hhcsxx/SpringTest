package net.chuangdie.lhb.bean;

public class ComImpl implements Com
{
	public void insertAll(Shopping shopping, Transaction trans) throws Exception
	{
		shopping.insert(shopping);
		throw new Exception();
		// trans.insert(trans);
	}
}
