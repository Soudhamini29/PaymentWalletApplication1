package com.cg.paymentapp.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.paymentapp.beans.Wallet;

public interface IWalletRepository extends JpaRepository<Wallet, Integer>{
	

}
