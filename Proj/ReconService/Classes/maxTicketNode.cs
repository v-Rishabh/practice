using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ReconService.Classes
{
    public class maxTicketNode : IComparer<maxTicketNode>
    {
        public int ticketCount;
        public int tripSequenceNumber;

        public maxTicketNode()
        {
            this.ticketCount = int.MinValue;
            this.tripSequenceNumber = int.MinValue;
        }

        public maxTicketNode(int ticketCount, int tripSequenceNumber)
        {
            this.ticketCount = ticketCount;
            this.tripSequenceNumber = tripSequenceNumber;
        }

        public int Compare(maxTicketNode a, maxTicketNode b)
        {
            if (a.ticketCount > b.ticketCount)
            {
                return 1;
            }
            if (a.ticketCount < b.ticketCount)
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }
    }
}
