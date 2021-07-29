package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class Flag extends FixedGameObject
{
    private int sequenceNumber = 1;

    public Flag(float x, float y, int sequenceNumber)
    {
        super(x, y);
        this.setSize(10);
        this.sequenceNumber = sequenceNumber;
        this.setColor(ColorUtil.BLUE);
    }
    private void setSize(int i) {
		// TODO Auto-generated method stub
		
	}
	//@return sequenceNumber
    public int getSequenceNumber()
    {
        return sequenceNumber;
    }
    
    @Override
    public void setColor(int color) {}

    public String toString()
    {
        String objDesc = super.toString();
        String localDesc = " seqNum=" + sequenceNumber;
        return "Flag:" + objDesc + localDesc;
    }
}