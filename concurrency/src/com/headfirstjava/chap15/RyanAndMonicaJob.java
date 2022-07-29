package com.headfirstjava.chap15;

class BankAccount
{
    private int balance = 100;

    public int getBalance()
    {
        return balance;
    }

    public void withdraw(int amount)
    {
        balance = getBalance() - amount;
    }
}

public class RyanAndMonicaJob implements Runnable
{
    // Только 1 экземпляр - доступ к одному банковскому счету
    private final BankAccount account = new BankAccount();

    public static void main(String[] args)
    {
        RyanAndMonicaJob theJob = new RyanAndMonicaJob();
        Thread one = new Thread(theJob);
        Thread two = new Thread(theJob);
        one.setName("Райан");
        two.setName("Моника");
        one.start();
        two.start();
    }

    @Override
    public void run()
    {
        // Зацикливание потока - попытка снять деньги со счета.
        // После снятия - проверка, чтобы убедиться, что лимит не превышен
        for (int i = 0; i < 10; i++) {
            makeWithdrawal(10);
            if (account.getBalance() < 0) {
                System.out.println("Превышение лимита!");
            }
        }
    }

    // метод должен выполняться как одна атомарная операция
    private synchronized void makeWithdrawal(int amount)
    {
        System.out.println(Thread.currentThread().getName() +
            " собирается снять деньги и проверяет баланс");
        if (account.getBalance() >= amount) {
            try {
                System.out.println(Thread.currentThread().getName() +
                    " идёт подремать");
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +
                " просыпается");
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() +
                " заканчивает транзакцию");
        } else {
            System.out.printf("Извините, для клиента %s недостаточно денег\n",
                Thread.currentThread().getName());
        }
    }
}
