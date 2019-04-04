using System.Collections.Generic;
using NUnit.Framework;
using ReadPDFiTextSharp;

namespace ReadPDF_TDD
{
    [TestFixture]
    public class ReadPDF_Test
    {
        // Declarations
        Dictionary<string, List<string>> data;
        Program obj;

        [SetUp]
        public void init() {
            data = new Dictionary<string, List<string>>();
            obj = new Program();
            data = obj.tests();
        }
        [Test]
        public void Creation() {
            int count = data.Count;
            Assert.AreEqual(5, count);
        }

        [Test]
        public void DataTest() {
            bool res = data.ContainsKey("28/03/2019");
            Assert.IsTrue(res);
        }

        [TearDown]
        public void CleanUp() {
            obj = null;
            data.Clear();
        }
    }
}