package rewards.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.orm.ObjectRetrievalFailureException;

import rewards.internal.account.Account;
import rewards.internal.account.AccountRepository;

import common.money.Percentage;

/**
 * A dummy account repository implementation. Has a single Account "Keith and Keri Donald" with two beneficiaries
 * "Annabelle" (50% allocation) and "Corgan" (50% allocation) associated with credit card "1234123412341234".
 * 
 * Stubs facilitate unit testing. An object needing an AccountRepository can work with this stub and not have to bring
 * in expensive and/or complex dependencies such as a Database. Simple unit tests can then verify object behavior by
 * considering the state of this stub.
 */
public class StubAccountRepository implements AccountRepository {

	private Map<String, Account> accountsByCreditCard = new HashMap<String, Account>();

	public StubAccountRepository() {
		Account account = new Account("123456789", "Keith and Keri Donald");
		account.addBeneficiary("Annabelle", Percentage.valueOf("50%"));
		account.addBeneficiary("Corgan", Percentage.valueOf("50%"));
		accountsByCreditCard.put("1234123412341234", account);
	}

	public Account findByCreditCardNumber(String creditCardNumber) {
		Account account = accountsByCreditCard.get(creditCardNumber);
		if (account == null) {
			throw new ObjectRetrievalFailureException(Account.class, creditCardNumber);
		}
		return account;
	}

	public void updateBeneficiaries(Account account) {
		// nothing to do, everything is in memory
	}

	@Override
	public <S extends Account> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Account> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Account> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Account> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Account> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Account entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Account> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account findBycreditCardNumber(String creditCardNumber) {
		// TODO Auto-generated method stub
		return null;
	}
}