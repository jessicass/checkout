﻿题目：超市结账系统
1.商品用大写字母来代替（A,B,C,...）。每个商品都单独计价，此外还有商品多个计价：买n个某商品，需要y美分。比如说，单个商品A需要价格是50美分，但是买三个商品A的价格是1.3美元。
2.定价表如下：
  Item     Unit Price     Special Price
  -------------------------------------
   A          50            3 for 130
   B          30            2 for 45
   C          20
   D          15
3.结账系统可以识别任何商品序列，比如我们扫描了一个B商品、一个A商品以及再一个B商品，结账系统就会识别到两个商品B并计价45美分（总价会是95美分）。
4.系统在进行结账之前可以制定定价规则。
5.结账系统的接口如下：
   co = CheckOut.new(pricing_rules)
   co.scan(item)
   co.scan(item)
       :    :
   price = co.total
6.实现price方法，该方法接收一个商品序列字符串，并且对每个商品调用scan方法，最后返回商品总价。
  class TestPrice < Test::Unit::TestCase

    def price(goods)
      co = CheckOut.new(RULES)
      goods.split(//).each { |item| co.scan(item) }
      co.total
    end

    def test_totals
      assert_equal(  0, price(""))
      assert_equal( 50, price("A"))
      assert_equal( 80, price("AB"))
      assert_equal(115, price("CDBA"))

      assert_equal(100, price("AA"))
      assert_equal(130, price("AAA"))
      assert_equal(180, price("AAAA"))
      assert_equal(230, price("AAAAA"))
      assert_equal(260, price("AAAAAA"))

      assert_equal(160, price("AAAB"))
      assert_equal(175, price("AAABB"))
      assert_equal(190, price("AAABBD"))
      assert_equal(190, price("DABABA"))
    end

    def test_incremental
      co = CheckOut.new(RULES)
      assert_equal(  0, co.total)
      co.scan("A");  assert_equal( 50, co.total)
      co.scan("B");  assert_equal( 80, co.total)
      co.scan("A");  assert_equal(130, co.total)
      co.scan("A");  assert_equal(160, co.total)
      co.scan("B");  assert_equal(175, co.total)
    end
  end